/* Ejemplo de laberinto
                    {"****",
                     "*?*?",
                     "??*?",
                     "E**?"}
*/
public class tareaN2{
    /*
       Utiliza "*" para caminar, utiliza "?" para las paredes y utiliza "E" para la salida
    */
    public boolean puedoSalir(int n, String[] maze){
        char grilla[][] = new char [n][n];
        char aux;
        for(int i=0; i < maze.length; i++){
            for(int j=0; j < maze[i].length(); j++){
                aux=maze[i].charAt(j);
                grilla[i][j]=aux;
            }
        }
        return sePuede(grilla,0,0);
    }
    
    private boolean sePuede(char grilla[][], int x, int y){
        boolean res = false;
        if(esValida(grilla,x,y)){
            if(grilla[x][y] == 'E'){
                res = true;
            }else{
                if(grilla[x][y] != '?' && grilla[x][y] != '$'){
                    grilla[x][y] = '$';//el $ sirve para dejar rastro
                    res =   sePuede(grilla, x, y+1) ||
                            sePuede(grilla, x+1, y) ||
                            sePuede(grilla, x, y-1) ||
                            sePuede(grilla, x-1, y);
                }
            }
        }
        return res;
    }
    
    private boolean esValida(char grilla[][], int x, int y){
        return x>=0 && x<grilla.length && y>=0 && y<grilla[x].length;
    }
}