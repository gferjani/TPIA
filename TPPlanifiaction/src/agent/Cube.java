package agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import environnement.Map;
import environnement.Place;

public class Cube
{
	private String nom;
	private Cube cubeDessus;
	private Cube cubeDessous;
	private Cube cubeButDessous;
	private boolean satifait=false;
	private boolean pousser=false;

	public Cube(Cube _cubeDessous,String _nom)
	{
		this.setNom(_nom);
		this.cubeDessous = _cubeDessous;
	}

	public void pousser()
	{
		if(this.cubeDessus!=null && !this.isSatifait())
		{
			this.cubeDessus.setPousser(true);
		}
	}

	public void move(List<Place> listplace)
	{
		Random rand = new Random();
		if (this.cubeDessus == null)
		{
			Map.deplacement(listplace.get(rand.nextInt(2)),this);
			this.setPousser(false);
		}
	}

	public List<Place> perceptionEnvironnement()
	{
		List<Place> listPlace = new ArrayList<Place>();
		listPlace=Map.recuperedeplacement(this);
		Map.donneVoisin(this);
		if(this.cubeButDessous==this.cubeDessous && !this.isPousser())
		{
			this.setSatifait(true);
		}
		else
		{
			this.setSatifait(false);
		}
		return listPlace;
	}
	
	public Cube getCubeDessous()
	{
		return cubeDessous;
	}

	public void setCubeDessous(Cube cubeDessous)
	{
		this.cubeDessous = cubeDessous;
	}

	public Cube getCubeDessus()
	{
		return cubeDessus;
	}

	public void setCubeDessus(Cube cubeDessus)
	{
		this.cubeDessus = cubeDessus;
	}
	public boolean isSatifait()
	{
		return satifait;
	}

	public void setSatifait(boolean satifait)
	{
		this.satifait = satifait;
	}

	public Cube getCubeButDessous()
	{
		return cubeButDessous;
	}

	public void setCubeButDessous(Cube cubeButDessous)
	{
		this.cubeButDessous = cubeButDessous;
	}

	public boolean isPousser()
	{
		return pousser;
	}

	public void setPousser(boolean pousser)
	{
		this.pousser = pousser;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}
}
