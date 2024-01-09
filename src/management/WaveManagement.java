package management;

import java.util.ArrayList;
import java.util.Arrays;

import action.Wave;
import scenes.Jouer;

public class WaveManagement {
    

    private Jouer jouer;
    private ArrayList<Wave> listeWaves = new ArrayList<>();;
    private int spawnLimite = 60*1;
    private int spawn = spawnLimite;
    private int indexMonstre, indexWave;
    private boolean waveTimer, waveTimerFini;
    private int waveLimite = 60*5;
    private int wave = 0;

    public WaveManagement (Jouer jouer){
        this.jouer=jouer;
        initWave();
    }

    private void initWave() {
        listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,1))));
        listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2,0,0,0,0,0,0,0,0,1))));

    }


    public void update () {
        if (spawn < spawnLimite){
            spawn++;
        }
        if(waveTimer){
            wave++;
            if(wave >= waveLimite){
                waveTimerFini = true;
            }
        }   
    }


    public void incrementeIndexWave () {
        indexWave++;
        waveTimerFini = false;
        waveTimer = false;
    }


    public int getMonstreSuivant () {
        spawn = 0;
        return listeWaves.get(indexWave).getListeMonstres().get(indexMonstre++);
    }

    public boolean placeDispoPourMonstre () {
        return indexMonstre < listeWaves.get(indexWave).getListeMonstres().size();
    }

    public int getIndexWave() {
        return indexWave;
    }

    public float getTempsRestant () {
        float secondesRestantes = waveLimite - wave;
        return secondesRestantes / 60.0f;
    }

    public ArrayList<Wave> getListeWaves() {
        return listeWaves;
    }

    public void setListeWaves(ArrayList<Wave> listeWaves) {
        this.listeWaves = listeWaves;
    }

    public boolean EstTempsPourNvMonstre() {
        return this.spawn >= this.spawnLimite;
    }

	public boolean EstEncoreDeWaves() {
		return indexWave +1 < listeWaves.size();
	}

	public void startWaveManagementTimer() {
        waveTimer = true;
	}

    public boolean tempsFiniPourWave() {
        return waveTimerFini;
    }

    public void resetIndexMonstre() {
        indexMonstre = 0;
    }

    public boolean timerdeWaveOK() {
        return waveTimer;
    }





}
