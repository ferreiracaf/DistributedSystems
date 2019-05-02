/**
 * FowardingAgent
 */
public class FowardingAgent {
    private Skeleton skeleton;

    public FowardingAgent() {
        try {
            skeleton = new Skeleton();
        } catch (Exception e) {
            System.out.println("FowardingAgent: "+e.getMessage());
        }
    }
    public String invoke(String message){
        // SPLITA AS MENSAGENS E AS MANDA PARA O SKELETON
        String ret = null;
        try {
            String array[] = new String[3];
            array = message.split(" ");
            

        	switch (array[1].toCharArray()[0]) {
        	case '+':
        		ret = skeleton.add(array[0], array[2]);
        		break;
        	case '-':
        		ret = skeleton.sub(array[0], array[2]);
        		break;
        	case '*':
        		ret = skeleton.mul(array[0], array[2]);
        		break;
        	case '/':
        		ret = skeleton.div(array[0], array[2]);
        		break;
        	default:
        		break;
        	}
        
        } catch (Exception e) {
            System.out.println("Sketon invoke: "+e.getMessage());
        }
        return ret;
    }
}