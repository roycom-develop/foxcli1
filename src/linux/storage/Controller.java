package linux.storage;

import java.util.ArrayList;

import linux.storage.instrument.Dev;

public class Controller implements Dev {
	private String chipModel;
	private String vendor;
	private int speed;
	private String fw;
	private boolean hasBBU;
	private ArrayList<Disk> disks;
	private int cacheSize;
	
	public Controller(String chipModel){
		this.setChipModel(chipModel);
		this.setVendor(vendor);
	}
	
	public void fillAttr(){
		switch(chipModel){
		case "3008":
			setVendor("lsi");
			setCacheSize(0);
			setSpeed(12);
			setHasBBU(false);
			break;
		default:
			break;
		}
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getChipModel() {
		return chipModel;
	}

	public void setChipModel(String chipModel) {
		this.chipModel = chipModel;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getFw() {
		return fw;
	}

	public void setFw(String fw) {
		this.fw = fw;
	}

	public boolean isHasBBU() {
		return hasBBU;
	}

	public void setHasBBU(boolean hasBBU) {
		this.hasBBU = hasBBU;
	}

	public ArrayList<Disk> getDisks() {
		return disks;
	}

	public void setDisks(ArrayList<Disk> disks) {
		this.disks = disks;
	}

	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}
}
