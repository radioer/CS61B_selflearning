public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        int numPlants = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String filename) {
        In in = new In(filename);
        int numPlants = in.readInt();
        Body[] res = new Body[numPlants];
        double radius = in.readDouble();
        for(int i = 0; i < numPlants; i++) {
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String name = in.readString();
            res[i] = new Body(xPos, yPos, xVel, yVel, mass, name);
        }
        return res;
    }

    public static void main(String[] args) {

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);

        /** draw */

        String background = "./images/starfield.jpg";
        StdDraw.enableDoubleBuffering();

        /** Sets up the universe so it goes from
         * -100, -100 up to 100, 100 */
        StdDraw.setScale(-radius, radius);
        StdAudio.play("audio/2001.mid");
        double t = 0;

        while (t < T){
            /* Clears the drawing window. */
            StdDraw.clear();
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];

            /* Stamps three copies of advice.png in a triangular pattern. */

            StdDraw.picture(0, 0, background);

            for(int i = 0; i < bodies.length; i++) {
                StdDraw.picture(bodies[i].xxPos, bodies[i].yyPos, "./images/" + bodies[i].imgFileName);
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);

            }
            for(int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }

            /* Shows the drawing to the screen, and waits 10 milliseconds. */
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

    }
}
