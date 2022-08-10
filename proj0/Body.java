public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static double G = 6.67e-11;
    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        double xBias = b.xxPos - xxPos;
        double yBias = b.yyPos - yyPos;
        double distance = Math.sqrt(Math.pow(xBias, 2) + Math.pow(yBias, 2));
        return distance;
    }

    public double calcForceExertedBy(Body b) {
        double force = (G * mass * b.mass) / (Math.pow(calcDistance(b), 2));
        return force;
    }

    public double calcForceExertedByX(Body b) {
        double force = calcForceExertedBy(b);
        double forceX = force * (b.xxPos - xxPos) / (calcDistance(b));
        return forceX;
    }

    public double calcForceExertedByY(Body b) {
        double force = calcForceExertedBy(b);
        double forceY = force * (b.yyPos - yyPos) / (calcDistance(b));
        return forceY;
    }

    public double calcNetForceExertedByX(Body[] bodies) {
        double sumForceX = 0;
        for (Body sBody : bodies){
            if(this.equals(sBody)) {
                continue;
            }
            sumForceX += calcForceExertedByX(sBody);
        }
        return sumForceX;
    }

    public double calcNetForceExertedByY(Body[] bodies) {
        double sumForceY = 0;
        for (Body sBody : bodies){
            if(this.equals(sBody)) {
                continue;
            }
            sumForceY += calcForceExertedByY(sBody);
        }
        return sumForceY;
    }

    public void update(double dt, double fX, double fY){
        double accX = fX / mass;
        double accY = fY / mass;
        xxVel = xxVel + dt * accX;
        yyVel = yyVel + dt * accY;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }
}
