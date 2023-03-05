package ie.tudublin;

import ddf.minim.AudioBuffer;
<<<<<<< HEAD
=======
// import ddf.minim.AudioBuffer;
>>>>>>> a924d0be1825b462d18134e1c026d01a4da8655a
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
<<<<<<< HEAD

import processing.core.PApplet;

public class Audio2 extends PApplet
{
    Minim m;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    FFT fft;

    float lerpedBuffer[];

    public void settings()
    {
        size(1024, 800);
=======
import processing.core.PApplet;

public class Audio2 extends PApplet{

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

    FFT fft;

    public void settings()
    {
        size(1024, 1024);
>>>>>>> a924d0be1825b462d18134e1c026d01a4da8655a
    }

    public void setup()
    {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedBuffer = new float[width];
<<<<<<< HEAD
        colorMode(HSB);
=======
>>>>>>> a924d0be1825b462d18134e1c026d01a4da8655a

        fft = new FFT(width, 44100);
    }

<<<<<<< HEAD

    public void draw()
    {
        background(0);
        stroke(255);
        float half = height / 2;
        int bufferSize = ab.size();
        for (int i = 0; i < bufferSize; i++)
        {
            
            stroke(map1(i, 0, bufferSize, 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i) * 10f, 0.1f);
            float f = abs(lerpedBuffer[i] * half);
            line(i, half + f, i, half - f);
        }
        
        fft.forward(ab);
        
        stroke(255);
        strokeWeight(1.0f);
        for (int i = 0; i < fft.specSize() * 0.25; i++)
        {
            line(i * 4, height, i * 4, height - fft.getBand(i) * 10);
        }

        
        
        // System.out.println(fft.getSpectrumImaginary().);
    }

=======
    float[] lerpedBuffer;
    public void draw()
    {
        background(0);
        colorMode(HSB);
        stroke(255);
        float half = height / 2;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
            float f = abs(lerpedBuffer[i] * half * 2.0f);
            line(i, half + f, i, half - f);
        }

        fft.forward(ab);
        stroke(255);

        int highestIndex = 0;
        for(int i = 0 ;i < fft.specSize() / 2 ; i ++)
        {
            line(i * 2.0f, height, i * 2.0f, height - fft.getBand(i) * 5.0f);

            if (fft.getBand(i) > fft.getBand(highestIndex))
            {
                highestIndex = i;
            }
        }

        float freq = fft.indexToFreq(highestIndex);
        fill(255);
        textSize(20);
        text("Freq: " + freq, 100, 100);

        float y = map(freq, 1000.0f, 2500.0f, height, 0);
        lerpedY = lerp(lerpedY, y, 0.1f);
        circle(200, y, 50);
        circle(300, lerpedY, 50);
        



        //println(map(5, 2, 10, 1000, 2000));
        //println(map1(5, 2, 10, 1000, 2000));
    }

    float lerpedY = 0;
    
>>>>>>> a924d0be1825b462d18134e1c026d01a4da8655a
    float map1(float a, float b, float c, float d, float e)
    {
        float range1 = c - b;
        float range2 = e - d;
<<<<<<< HEAD
        float dist = a - b;

        return d + (dist / range1) * range2;
=======
        float howFar = a - b;

        return d + (howFar / range1) * range2;
>>>>>>> a924d0be1825b462d18134e1c026d01a4da8655a
    }
}
