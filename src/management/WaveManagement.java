package management;

import java.util.ArrayList;
import java.util.Arrays;

import action.Wave;
import scenes.Jouer;
import scenes.Jouer.Difficulty;

import java.util.Random;

public class WaveManagement {
    

    private Jouer jouer;
    private ArrayList<Wave> listeWaves = new ArrayList<>();;
    private int spawnLimite = 60*1;
    private int spawn = spawnLimite;
    private int indexMonstre, indexWave;
    private boolean waveTimer, waveTimerFini;
    private int waveLimite = 60*5;
    private int wave = 0;

    private Random random;

    public WaveManagement (Jouer jouer,Difficulty difficulty){
        this.jouer=jouer;
        this.random = new Random();
        initWave(difficulty);
    }

    private void initWave(Difficulty difficulty) {
       
        if(difficulty== Jouer.Difficulty.FACILE){
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2,2,2,2,2,2,2))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2,2,2,2,2,0,2,1))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndIntNull()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));

        }
        if(difficulty== Jouer.Difficulty.MOYEN){
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2,2,2,2,2,0,1,3,0,2,1,3,1,0,0,0))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2,2,1,0,0,2,3,1))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,1,3,2,1,0,2,1))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1,2,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2,0,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1,0,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1,0,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1,0,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,3,3,3,3,3,3,3,3,3,3,3,3,1,1,1,1,2,2,2,3,3,3,1,1,1,0,0,0,0,0,0,0))));

        }
        if(difficulty== Jouer.Difficulty.DIFFICILE){
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,2,0,2,2,0,1,3,0,2,1,3,1,0,0,0,getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),2,getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2,2,getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),2,getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,3,3,3,3,3,3,3,3,3,3,3,3,1,1,1,1,2,2,2,3,3,3,1,1,1,0,0,0,0,0,0,0))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),2,getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),2,getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),2,getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,3,3,3,3,3,3,3,3,3,3,3,3,1,1,1,1,2,2,2,3,3,3,1,1,1,0,0,0,0,0,0,0))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndInt(),0,getRndInt(),0,0,0,1,1,1,1,getRndInt(),1,1,0,0,0,3,3,3,3,3,getRndInt(),3,3,3,3,3,3,1,1,1,1,2,2,2,3,3,3,1,1,1,0,getRndInt(),0,0,getRndInt(),0,0))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),0,0,0,0,0,0,1,1,1,1,1,1,1))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),0,getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1))));
        }

    }

    private int getRndInt(){
        return random.nextInt(4);
    }
    private int getRndIntNull(){
        return random.nextInt(2);
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
        if (jouer.getCurrentDifficulty() == Jouer.Difficulty.MARATHON && besoinDePlusDeVagues()) {
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2,2,1,getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),0,0,3,3,0,3,1,1,0,1,1,1,getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt()))));
            listeWaves.add(new Wave(new ArrayList<Integer>(Arrays.asList(getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt(),getRndInt(),getRndIntNull(),getRndInt(),getRndIntNull(),getRndInt()))));
        } 
    }

    private boolean besoinDePlusDeVagues() {
        return indexWave >= listeWaves.size() - 1;
    }

    public void reset(Difficulty difficulty){
        listeWaves.clear();
        initWave(difficulty);
        indexMonstre = 0;
        indexWave =0;
        waveTimer = false;
        waveTimerFini = false;
        wave = 0;
        spawn = spawnLimite;
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
