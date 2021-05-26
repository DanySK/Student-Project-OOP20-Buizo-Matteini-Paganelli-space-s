package spaceSurvival.utilities;

import java.util.ArrayList;
import java.util.List;

public enum SoundType {
 LOOP , EFFECT;

	public List<SoundPath> getSoundPaths() {
		 
		ArrayList <SoundPath> list = new ArrayList<>();		 
		for (SoundPath path : SoundPath.values()){
			if(path.getType() == this){
				list.add(path);
			 }
		 }
		 return list ;
	}
}