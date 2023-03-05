package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

import processing.core.PApplet;

public class Audio2 extends PApplet
{
    Minim m;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    PitchSpeller ps;
    FFT fft;

    float lerpedBuffer[];

    public void settings()
    {
        size(1024, 800);
    }

    public void setup()
    {
        m = new Minim(this);
        ap = m.loadFile("./OOP-2023/data/scale.wav", 1024);
        ab = ap.mix;
        ap.play();
        // ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        lerpedBuffer = new float[width];
        colorMode(HSB);

        fft = new FFT(width, 44100);

        ps = new PitchSpeller();
    }


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
            line(i * 4, height, i * 4, height - fft.getBand(i));
        }

        int highestBin = 0;
		for(int i = 0 ; i < fft.specSize() ; i ++)
		{
			line(i, 0, i, fft.getBand(i) * 100);
			if (fft.getBand(i) > fft.getBand(highestBin))
			{
				highestBin = i;
			}
		}

		float freq1 = fft.indexToFreq(highestBin);
        text(ps.spell(freq1), width / 2, height * 0.2f);

    }

    float map1(float a, float b, float c, float d, float e)
    {
        float range1 = c - b;
        float range2 = e - d;
        float dist = a - b;

        return d + (dist / range1) * range2;
    }
}
