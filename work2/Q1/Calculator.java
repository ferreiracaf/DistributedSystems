public class Calculator {
    
    public double add(double a, double b){
        return (a+b); 
    }
    
    public double sub(double a, double b){
        return (a-b); 
    }
    
    public double mul(double a, double b){
        return (a*b); 
    }
    
    public double div(double a, double b){
        return (a/b); 
    }
    
    public double calc(double val1, double val2, char op) {
		double resp = 0;
		switch (op) {
		case '+':
			resp = this.add(val1, val2);
			break;
		case '-':
			resp = this.sub(val1, val2);
			break;
		case '*':
			resp = this.mul(val1, val2);
			break;
		case '/':
			if(val2 != 0)
				resp = this.div(val1, val2);
			break;
		default:
			break;
		}
		return resp; 
	}
}
