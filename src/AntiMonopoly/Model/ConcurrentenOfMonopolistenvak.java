package AntiMonopoly.Model;

import org.apache.commons.collections4.map.LinkedMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentenOfMonopolistenvak extends Tegel {
	private Opdrachten opdracht = new Opdrachten();

	public String neemOpdrachtMon() {
		return opdracht.getShuffledMon().getValue(opdracht.getShuffledMon().firstKey());
	}

	public String neemOpdrachtCon() {
		return opdracht.getShuffledCon().getValue(opdracht.getShuffledCon().firstKey());
	}

	public void steekTerugMon() {
		List<Integer> keys = new ArrayList(opdracht.getShuffledMon().keySet());
		LinkedMap<Integer,String> rotatedMon = new LinkedMap<>();
		Collections.rotate(keys, -1);											/** .rotate methode en -1 zorgt ervoor dat eerste de laatste key wordt en alles opschuift */
		for (Integer i : keys){
			String value = opdracht.getShuffledMon().getValue(i);
			rotatedMon.put(i,value);													/** plaats de waarde voor index i uit originele lijst in nieuwe map */
		}
		opdracht.setShuffledMon(rotatedMon);
	}

	public void steekTerugCon() {
		List<Integer> keys = new ArrayList(opdracht.getShuffledCon().keySet());
		LinkedMap<Integer,String> rotatedCon = new LinkedMap<>();
		Collections.rotate(keys, -1);
		for (Integer i : keys){
			String value = opdracht.getShuffledCon().getValue(i);
			rotatedCon.put(i,value);
		}
		opdracht.setShuffledCon(rotatedCon);
	}
	public static void main(String[] args) {
		System.out.println(new ConcurrentenOfMonopolistenvak().neemOpdrachtCon());       /** Testcode */
		System.out.println(new ConcurrentenOfMonopolistenvak().neemOpdrachtMon());
	}

}