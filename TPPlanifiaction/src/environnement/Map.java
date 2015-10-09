package environnement;

import java.util.ArrayList;
import java.util.List;

import agent.Cube;

public class Map
{
	private Cube cubeA=new Cube(null,"A");
	private Cube cubeB=new Cube(cubeA,"B");
	private Cube cubeC=new Cube(cubeB,"C");
	private Cube cubeD=new Cube(cubeC,"D");
	private List<Cube> lesCubes;
	private static Cube[][] matrice;
	private static Map map;
	public List<Cube> getLesCubes()
	{
		return lesCubes;
	}
	private Map()
	{
		matrice=new Cube[3][4];
		this.lesCubes=new ArrayList<Cube>();
		this.initialize();
	}
	public static Map getMap()
	{
		if(map==null)
		{
			map=new Map();
		}
		return map;
	}
	
	public void initialize()
	{
		matrice[0][0]=cubeA;
		matrice[0][1]=cubeB;
		matrice[0][2]=cubeC;
		matrice[0][3]=cubeD;
		this.cubeA.setCubeDessus(cubeB);
		this.cubeB.setCubeDessus(cubeC);
		this.cubeC.setCubeDessus(cubeD);
		this.cubeD.setCubeButDessous(cubeB);
		this.cubeB.setCubeButDessous(cubeA);
		this.cubeA.setCubeButDessous(cubeC);
		this.cubeC.setCubeButDessous(null);
		lesCubes.add(cubeA);
		lesCubes.add(cubeB);
		lesCubes.add(cubeC);
		lesCubes.add(cubeD);
	}
	public static List<Place> recuperedeplacement(Cube cube)
	{
		List<Place> listPlace=new ArrayList<Place>();
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(matrice[i][j]==cube)
				{
					for(int x=0;x<4;x++)
					{
						if(matrice[(i+1)%3][x]==null)
						{
							listPlace.add(new Place((i+1)%3,x));
							break;
						}
					}
					for(int x=0;x<4;x++)
					{
						if(matrice[(i+2)%3][x]==null)
						{
							listPlace.add(new Place((i+2)%3,x));
							break;
						}
					}
				}
			}
		}
		return listPlace;
	}
	public static void deplacement(Place place,Cube cube)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(matrice[i][j]==cube)
				{
					matrice[i][j]=null;
				}
			}
		}
		matrice[place.getX()][place.getY()]=cube;
	}
	public boolean touSatisfait()
	{
		for(Cube cube:lesCubes)
		{
			if(!cube.isSatifait())
			{
				return false;
			}
		}
		return true;
	}
	public static void donneVoisin(Cube cube)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(matrice[i][j]==cube)
				{
					if(j>0)
					{
						if(matrice[i][j-1]!=null)
						{
							cube.setCubeDessous(matrice[i][j-1]);
						}
						else
						{
							cube.setCubeDessous(null);
						}
					}
					else
					{
						cube.setCubeDessous(null);
					}
					if(j<3)
					{
						if(matrice[i][j+1]!=null)
						{
							cube.setCubeDessus(matrice[i][j+1]);
						}
						else
						{
							cube.setCubeDessus(null);
						}
					}
					else
					{
						cube.setCubeDessus(null);
					}
				}
			}
		}
	}
	public void afficher()
	{
		for(int j=3;j>-1;j--)
		{
			for(int i=0;i<3;i++)
			{
				if(matrice[i][j]!=null)
				{
					System.out.print(((Cube)matrice[i][j]).getNom()+"   ");
				}
				else
				{
					System.out.print("    ");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
	
}
