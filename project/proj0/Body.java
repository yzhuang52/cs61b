public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        return Math.sqrt(Math.pow((this.xxPos-b.xxPos),2)+Math.pow((this.yyPos-b.yyPos),2));
    }

    public double calcForceExertedBy(Body b){
        return (6.67*Math.pow(10, -11)*this.mass*b.mass)/Math.pow(this.calcDistance(b),2);
    }
}
