/**
 *
 * @author Jv Loreti
 */

public class Jogo{
    private int face1;
    private int face2;
    private int somatoria;
    private int tentativas;
    
    public Jogo(){
        face1 = (int)(Math.random() * 6 + 1);
        face2 = (int)(Math.random() * 6 + 1);
        
        somatoria = face1 + face2;
        
        tentativas = 3;
    }
    
    public boolean jogar(int aposta){
        if(tentativas > 0){
            tentativas--;
            if(aposta == somatoria){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return String.format("Face 1: %d, Face 2: %d, Somatória: %d", face1, face2, somatoria);
    }
    
    //Getters e setters
    public int getTentativas(){
        return tentativas;
    }
}
