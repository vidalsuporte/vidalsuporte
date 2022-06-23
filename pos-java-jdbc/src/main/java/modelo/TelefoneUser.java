package modelo;

public class TelefoneUser {
Long id;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public Long getIdUserPosJava() {
	return idUserPosJava;
}
public void setIdUserPosJava(Long idUserPosJava) {
	this.idUserPosJava = idUserPosJava;
}
String numero;
String tipo;
Long idUserPosJava;

@Override
public String toString() {
	return "TelefoneUser [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", idUserPosJava=" + idUserPosJava
			+ "]";
}



}
