package le13.exercicios.ex04.chatgpt;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

class Tamanho 
{
    private Map<String, Long> mapa = new HashMap<>();

    public synchronized void adicionarTamanho(String nomeArquivo, long tamanho) 
    {
        mapa.put(nomeArquivo, tamanho);
        notifyAll();
    }

    public synchronized long obterTamanho(String nomeArquivo) throws InterruptedException 
    {
        while (!mapa.containsKey(nomeArquivo)) 
        {
            wait();
        }
        return mapa.get(nomeArquivo);
    }
}

class ObterDiretorio implements Runnable 
{
    private final Tamanho tamanho;
    private final File diretorio;

    public ObterDiretorio(Tamanho tamanho, File diretorio) 
    {
        this.tamanho = tamanho;
        this.diretorio = diretorio;
    }

    private void calcularTamanho(File arquivo) 
    {
        if (arquivo.isFile()) 
        {
            long tamanhoArquivo = arquivo.length();
            tamanho.adicionarTamanho(arquivo.getAbsolutePath(), tamanhoArquivo);
        } 
        else if (arquivo.isDirectory()) 
        {
            File[] arquivos = arquivo.listFiles();
            if (arquivos != null) 
            {
                for (File subarquivo : arquivos) 
                {
                    System.out.println(subarquivo);
                	calcularTamanho(subarquivo);
                }
            }
        }
    }

    @Override
    public void run() 
    {
        calcularTamanho(diretorio);
    }
}

class CalcularTamanhoDiretorio implements Runnable 
{
    private final Tamanho tamanho;
    private final File diretorio;

    public CalcularTamanhoDiretorio(Tamanho tamanho, File diretorio) 
    {
        this.tamanho = tamanho;
        this.diretorio = diretorio;
    }

    private long calcularTamanho(File arquivo) throws InterruptedException 
    {
        long tamanhoTotal = 0;

        if (arquivo.isFile()) 
        {
            return tamanho.obterTamanho(arquivo.getAbsolutePath());
        } 
        else if (arquivo.isDirectory()) 
        {
            File[] arquivos = arquivo.listFiles();
            if (arquivos != null) 
            {
                for (File subarquivo : arquivos) 
                {
                    tamanhoTotal += calcularTamanho(subarquivo);
                }
            }
        }

        return tamanhoTotal;
    }

    @Override
    public void run() 
    {
        try 
        {
            long tamanhoReal = calcularTamanho(diretorio);
            long tamanhoDisco = tamanhoReal * 4096; // Tamanho em disco considerando o tamanho de cluster do NTFS
            System.out.println("Tamanho real do diretório: " + tamanhoReal + " bytes");
            System.out.println("Tamanho ocupado em disco: " + tamanhoDisco + " bytes");
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}

public class ChatGPT 
{
    public static void main(String[] args) 
    {
        // Caminho do diretório fornecido pelo usuário
        String diretorioPath = "C:\\TSI\\2023 - 01\\TOO\\Atividades\\LE13\\files\\arquivos";

        // Criar uma instância da classe File com o caminho do diretório
        File diretorio = new File(diretorioPath);

        // Criar o objeto compartilhado para armazenar os tamanhos
        Tamanho tamanho = new Tamanho();

        // Criar e iniciar a thread produtora
        Thread threadProdutora = new Thread(new ObterDiretorio(tamanho, diretorio));
        threadProdutora.start();

        // Obter o tempo inicial
        long tempoInicial = System.nanoTime();

        // Criar e iniciar a thread consumidora
        Thread threadConsumidora = new Thread(new CalcularTamanhoDiretorio(tamanho, diretorio));
        threadConsumidora.start();

        try 
        {
            // Aguardar a conclusão da thread produtora
            threadProdutora.join();

            // Aguardar a conclusão da thread consumidora
            threadConsumidora.join();

            // Obter o tempo final
            long tempoFinal = System.nanoTime();

            // Calcular o tempo gasto em segundos ou minutos
            long tempoGasto = (tempoFinal - tempoInicial) / 1_000_000_000; // em segundos
            String unidadeTempo = "segundos";
            
            if (tempoGasto >= 60) 
            {
                tempoGasto /= 60; // em minutos
                unidadeTempo = "minutos";
            }

            // Exibir os tempos inicial, final e gasto
            System.out.println("Tempo inicial: " + formatarTempo(tempoInicial));
            System.out.println("Tempo final: " + formatarTempo(tempoFinal));
            System.out.println("Tempo gasto: " + tempoGasto + " " + unidadeTempo);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

    // Método para formatar o tempo no formato hh:mm:ss.ns
    private static String formatarTempo(long tempo) 
    {
        long segundos = tempo / 1_000_000_000;
        long minutos = segundos / 60;
        long horas = minutos / 60;
        segundos %= 60;
        minutos %= 60;

        return String.format("%02d:%02d:%02d.%09d", horas, minutos, segundos, tempo % 1_000_000_000);
    }
}