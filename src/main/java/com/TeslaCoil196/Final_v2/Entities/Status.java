package com.TeslaCoil196.Final_v2.Entities;

public class Status {
		
		String stat;
		String id;
		
		public Status() {}
		
		public Status(String v1,String v2) {
			stat=v1;
			id=v2;
		}

		public String getStat() {
			return stat;
		}

		public void setStat(String stat) {
			this.stat = stat;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

}
