import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class PodRace {
    public static Set<Pod> race(double distance, Set<Pod> racers, double timeSlice, double timeLimit) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Pod has to move forward");
        }
        if (timeLimit < 0) {
            throw new IllegalArgumentException("Time cannot be negative");
        }
        if (timeSlice <= 0 || timeSlice > 2) {
            throw new IllegalArgumentException("Time cannot be zero or negative and slices must be less than 2");
        }

        var distances = new HashMap<Pod, Double>();

        var winners = new HashSet<Pod>();
        for (var t = 0; t < timeLimit; t += timeSlice) {
            for (var pod : racers) {
                var distanceForThisTimeSlice = pod.distanceTraveled(t, t+timeSlice, 1);
                distances.put(pod, distances.getOrDefault(pod, 0.0) + distanceForThisTimeSlice);
                if (distances.get(pod) >= distance) {
                    winners.add(pod);
                }
            }
            if (winners.isEmpty() != true) {
                return winners;
            }
        }
        return winners;
}
