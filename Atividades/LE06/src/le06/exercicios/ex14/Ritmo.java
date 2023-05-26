package le06.exercicios.ex14;

public class Ritmo 
{
	private String km, tempo;

	public Ritmo() 
	{
		km = tempo = "";
	}

	public Ritmo(String km, String tempo) 
	{
		this.km = km;
		this.tempo = tempo;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	@Override
	public String toString() 
	{
		return String.format("%s Km: %s", km, tempo);
	}
}
