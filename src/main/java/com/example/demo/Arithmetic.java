package com.example.demo;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

@Named
@SessionScoped
public class Arithmetic implements Serializable {
    private int start;
    private int end;
    private double step;
    private double value;

    private List<Point> points = new ArrayList<>();

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void fillingListOfPoints(double start, double end, double step, double value){
        double currentVal = start;
        while(currentVal<=end){
            double result = calculateFunction(currentVal,value);
            points.add(new Point(currentVal, result));
            currentVal += step;
        }
    }

    public double calculateFunction(double x, double a){
        double eps = 0.0000000000000004;
        if (x > a + eps) return x*(sqrt(x-a));
        else if (x < a - eps) return (exp(-a*x))*cos(a*x);
        else return x*sin(a*x);
    }

    public int findMinIndex(){
        double minResult = Double.MAX_VALUE;
        int valNum = 0;
        for(int i = 0; i < points.size();i++) {
            if (points.get(i).getY() < minResult) {
                minResult = points.get(i).getY();
                valNum = i;
            }
        }
        return valNum;
    }

    public int findMaxIndex(){
        double maxResult = Integer.MIN_VALUE;
        int valNum = 0;
        for(int i = 0; i < points.size();i++) {
            if (points.get(i).getY() > maxResult) {
                maxResult = points.get(i).getY();
                valNum = i;
            }

        }
        return valNum;
    }

    public Point getMinPoint(){
        return points.get(findMinIndex());
    }

    public Point getMaxPoint(){
        return points.get(findMaxIndex());
    }

    public double summPoints(){
        double summ = 0;
        for(Point point:points){
            summ += point.getY();
        }
        return summ;
    }

    private double round(double val) {
        return (double) Math.round(val * 1000) / 1000;
    }

    public double averageOfPoints(){
        return round(summPoints())/points.size();
    }

}

//  Функция:                      Условие      Начальные данные         Диапазон и шаг
//      x*(sqrt(x-a))               x>a                                 x є [1,5]
//      x*sin(ax)                   x=a             a=2.4               deltaX = 0.01
//      pow(e, -a*x)*cos(ax)        x<a
//
/*
    public static void main(String[] args) {
         Arithmetic arithmetic = new Arithmetic();
         arithmetic.print();
    }

    public void print(){
        fillingListOfPoints(getStart(), getEnd(), getStep(), getValue());
        for(Point point : points)System.out.println(point);
        System.out.println(getMinPoint());
        System.out.println(getMaxPoint());
        System.out.println(summPoints());
        System.out.println(averageOfPoints());
    }*/