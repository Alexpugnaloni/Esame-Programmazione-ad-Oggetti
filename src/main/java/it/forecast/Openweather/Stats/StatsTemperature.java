package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

@Service
public class StatsTemperature extends Stats {

    @Override
    public List<WeatherData> getStats(String statsType, Vector<WeatherData> list) {

        switch (statsType) {

            case "max":

                result = new Vector<WeatherData>();
                MaxValue = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    WeatherData wD = list.get(i);
                    if (wD.getTemperature() > MaxValue.getTemperature()) {
                        MaxValue = wD;
                    }
                }
                result.add(MaxValue);
                return result;

            case "min":

                result = new Vector<WeatherData>();

                MinValue = list.get(0);
                for (int i = 1; i < list.size(); i++) {

                    WeatherData wD = list.get(i);
                    if (wD.getTemperature() < MinValue.getTemperature()) {
                        MinValue = wD;
                    }
                }
                result.add(MinValue);

            case "variance":
                Vector<Double> v = new Vector<Double>();
                Double sum = (double) 0, sumSquareRej = (double) 0, variance, avg;
                int size;
                for (int i = 0; i < list.size(); i++) {
                    v.add(list.elementAt(i).getTemperature());
                }
                size = v.size();
                for (int i = 0; i < size; i++) {
                    sum = sum + v.elementAt(i);
                }
                avg = sum / size;
                for (int i = 0; i < size; i++) {

                    sumSquareRej = sumSquareRej + Math.pow(v.elementAt(i) - avg, 2);
                }

                variance = sumSquareRej / size;
                Vector<WeatherData> WeatherDataVariance = new Vector<WeatherData>();
                WeatherData finalVariance = new WeatherData();

                finalVariance.setTemperature(variance);
                WeatherDataVariance.add(finalVariance);
                return WeatherDataVariance;

            case "average":
                Vector<Double> v2 = new Vector<Double>();
                Double sum2 = (double) 0, avg2;
                int sizeAvg;
                for (int i = 0; i < list.size(); i++) {
                    v2.add(list.elementAt(i).getTemperature());
                }
                sizeAvg = v2.size();
                for (int i = 0; i < sizeAvg; i++) {
                    sum2 = sum2 + v2.elementAt(i);
                }
                avg = sum2 / sizeAvg;
                for (int i = 0; i < sizeAvg; i++) {
                    sum2 = sum2 + v2.elementAt(i);
                }

                avg2 = sum2 / sizeAvg;
                Vector<WeatherData> WeatherDataAverage = new Vector<WeatherData>();
                WeatherData finalAverage = new WeatherData();

                finalAverage.setTemperature(avg2);
                WeatherDataAverage.add(finalAverage);
                return WeatherDataAverage;

            default: {
            }
        }
        return null;
    }
}
