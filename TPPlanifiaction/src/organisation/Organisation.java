package organisation;

import java.util.List;

import agent.Cube;
import environnement.Map;
import environnement.Place;

public class Organisation
{

	public static void main(String[] args)
	{
		Map map=Map.getMap();
		map.afficher();
		int i=0;
		while(i<500 && !map.touSatisfait())
		{
			for(Cube cube:map.getLesCubes())
			{
				List<Place> places=cube.perceptionEnvironnement();
				if(!cube.isSatifait())
				{
					if(cube.getCubeDessus()==null)
					{
						cube.move(places);
						map.afficher();
					}
					else
					{
						cube.pousser();
					}
				}
			}
			i++;
		}
	}

}
