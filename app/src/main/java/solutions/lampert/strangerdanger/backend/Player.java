package solutions.lampert.strangerdanger.backend;

/**
 * Created by andrew on 11/28/15.
 */
public class Player {

    private int m_id;
    private int m_level;
    private int m_xp;

    // Methods

    // return vals
    public int id(){
        return m_id;
    }

    public int level(){
        return m_level;
    }

    public int xp(){
        return m_xp;
    }

    // set vals
    public void id (int val) {
        m_id = val;
    }

    public void level(int val){
        if(val > 0 && val <= 100){
            m_level = val;
        }
    }

    public void add_xp(int val) {
        if (val > 0) {
            m_xp += val;
        }
    }

}
