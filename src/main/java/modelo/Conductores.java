package modelo;

public class Conductores {
	private int idcond;
	private int iduser;
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public int getIdcond() {
		return idcond;
	}
	public void setIdcond(int idcond) {
		this.idcond = idcond;
	}
	public String getConductor() {
		return conductor;
	}
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
	private String conductor;
}
