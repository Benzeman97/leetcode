package com.benz.demo.pattern.structural;
/*

class University
{

    public void work()
    {
            Pen pen = new PenAdepter();

            Assignment assignment=new Assignment();

            assignment.setP(pen);

            assignment.write("i bit tired to write the assignment");

    }
}

class Assignment{

    private Pen p;

    public Pen getP() {
        return p;
    }

    public void setP(Pen p) {
        this.p = p;
    }

    public void write(String str)
    {
        p.write(str);
    }
}

interface  Pen{
    void write(String str);
}

class PilotPen{

    public void mark(String str)
    {
        System.out.println(str);
    }
}

public class PenAdepter implements Pen{

    @Override
    public void write(String str) {
        PilotPen pilotPen=new PilotPen();
        pilotPen.mark(str);
    }

}
*/

class University{

    public void doAssignment()
    {
        Pen pen =new PenAdepter();

        Assignment assignment=new Assignment();
        assignment.setPen(pen);
        assignment.write("I am bit tired to write an assignment");
    }
}

class Assignment{

    private Pen pen;

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void write(String msg)
    {
         pen.write(msg);
    }
}

interface Pen{
    void write(String msg);
}

class PilotPen{

    public void mark(String msg)
    {
        System.out.println(msg);
    }
}

public class PenAdepter implements Pen{

    @Override
    public void write(String msg) {
        PilotPen pilotPen=new PilotPen();
        pilotPen.mark(msg);
    }

    public void start()
    {
        new University().doAssignment();
    }
}
