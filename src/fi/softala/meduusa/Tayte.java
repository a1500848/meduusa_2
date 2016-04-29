package fi.softala.meduusa;

public class Tayte {

		int tayteid;
		String taytenimi;
			
		public Tayte() {		
		}
				
		public Tayte( int tayteid, String taytenimi){
				this.tayteid = tayteid;
				this.taytenimi = taytenimi;
				}	

		public int getTayteid() {
			return tayteid;
		}

		public void setTayteid(int tayteid) {
			this.tayteid = tayteid;
		}

		public String getTaytenimi() {
			return taytenimi;
		}

		public void setTaytenimi(String taytenimi) {
			this.taytenimi = taytenimi;
		}
		
		@Override
		public String toString() {
			return "Tayte [tayteid=" + tayteid + ", taytenimi=" + taytenimi
					+ "]";
		}

		public void add(Tayte tayte) {
			// TODO Auto-generated method stub
			
		}
}
