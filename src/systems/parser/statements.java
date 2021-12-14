package systems.parser;

/**
 *
 * @author Yahia, Nour, Moustafa, Ahmed, Ramy
 */
public class statements {
    public String name,kind,opcode;
    public int opreands,format; 

    public statements(String name, int opreands, int format, String kind,String opcode) {
        this.name = name;
        this.opreands = opreands;
        this.format = format;
        this.kind= kind;
        this.opcode=opcode;
    }
    
}
