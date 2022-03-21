import examples.StdDraw;

public class NBody {
    public static double readRadius(String file){
        In in = new In(file);
        double planet_number = in.readDouble();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String file){
        In in = new In(file);
        Body[] b = new Body[5];
        double xxPos;
        double yyPos;
        double xxVol;
        double yyVol;
        double mass;
        String picture;
        double a = in.readDouble();
        double aa = in.readDouble();
        for(int i=0;i<b.length;i++){
            xxPos = in.readDouble();
            yyPos = in.readDouble();
            xxVol = in.readDouble();
            yyVol = in.readDouble();
            mass = in.readDouble();
            picture = in.readString();
            Body bb = new Body(xxPos,yyPos, xxVol, yyVol, mass, picture);
            b[i] = bb;
        }
        return b;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] b = readBodies(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        for(double current_time=0; current_time<T;current_time+=dt){
            double[] xForces = new double[5];
            double[] yForces = new double[5];
            for(int i=0;i<b.length;i++){
                xForces[i] = b[i].calcNetForceExertedByX(b);
                yForces[i] =  b[i].calcNetForceExertedByY(b);
            }
            for(int i=0;i<b.length;i++){
                b[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0,"./images/starfield.jpg");
            for(int i=0;i<b.length;i++){
                StdDraw.picture(b[i].xxPos, b[i].yyPos, "./images/"+b[i].imgFileName);
            }
            StdDraw.show();
            StdDraw.pause(10);
        }


    }

}
