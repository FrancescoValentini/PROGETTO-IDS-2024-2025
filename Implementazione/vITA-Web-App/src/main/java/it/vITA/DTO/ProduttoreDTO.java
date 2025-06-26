package it.vITA.DTO;

public class ProduttoreDTO {
	private String username;
	private String password;
	private String email; 
	private String nome;
	private String cognome;
	private String telefono;
	private String biografia;
	private String partitaIva;
	private String denominazioneAzienda;
	private String telefonoAziendale;
	private String idPosizione;

	    public ProduttoreDTO() {}

	    public ProduttoreDTO(String username, String password, String email, String nome, String cognome,
				String telefono, String biografia, String partitaIva, String denominazioneAzienda, String telefonoAziendale,
				String idPosizione) {
			this.username = username;
			this.password = password;
			this.email = email;
			this.nome = nome;
			this.cognome = cognome;
			this.telefono = telefono;
			this.biografia = biografia;
			this.partitaIva = partitaIva;
			this.denominazioneAzienda = denominazioneAzienda;
			this.telefonoAziendale = telefonoAziendale;
			this.idPosizione = idPosizione;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getBiografia() {
			return biografia;
		}

		public void setBiografia(String biografia) {
			this.biografia = biografia;
		}

		public String getPartitaIva() {
			return partitaIva;
		}

		public void setPartitaIva(String partitaIva) {
			this.partitaIva = partitaIva;
		}

		public String getDenominazioneAzienda() {
			return denominazioneAzienda;
		}

		public void setDenominazioneAzienda(String denominazioneAzienda) {
			this.denominazioneAzienda = denominazioneAzienda;
		}

		public String getTelefonoAziendale() {
			return telefonoAziendale;
		}

		public void setTelefonoAziendale(String telefonoAziendale) {
			this.telefonoAziendale = telefonoAziendale;
		}

		

		@Override
		public String toString() {
			return "ProduttoreDTO [username=" + username + ", password=" + password + ", email=" + email + ", nome="
					+ nome + ", cognome=" + cognome + ", telefono=" + telefono + ", biografia=" + biografia
					+ ", partitaIva=" + partitaIva + ", denominazioneAzienda=" + denominazioneAzienda
					+ ", telefonoAziendale=" + telefonoAziendale + ", idPosizioneGeografica=" + idPosizione
					+ "]";
		}

		public String getIdPosizione() {
			return idPosizione;
		}

		public void setIdPosizione(String idPosizione) {
			this.idPosizione = idPosizione;
		}



}

