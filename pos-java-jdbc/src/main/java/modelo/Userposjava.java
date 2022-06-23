package modelo;

public class Userposjava {
long id;
String nome;
String email;

public long getId() {
	return id;
}
public void setId(long l) {
	this.id = l;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Userposjava [id=" + id + ", nome=" + nome + ", email=" + email + "]";
}






}
