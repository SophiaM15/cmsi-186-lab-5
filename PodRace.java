import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class PodRace {
    public static Set<Pod> race(double distance, Set<Pod> racers, double timeSlice, double timeLimit) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Pod has to move forward");
        }
        if (timeSlice <= 0) {
            throw new IllegalArgumentException("Time cannot be zero or negative");
        }
        if (timeSlice > 2) {
            throw new IllegalArgumentException("Time slice must be less than two");
        }

        var distances = new HashMap<Pod, Double>();

        var winners = new HashSet<Pod>();
        for (var t = 0; t < timeLimit; t += timeSlice) {
            for (var pod : racers) {
                var distanceForThisTimeSlice = pod.distanceTraveled(0, timeLimit, timeSlice);
                distances.put(pod, distances.getOrDefault(pod, 0.0) + distanceForThisTimeSlice);
                if (distances.get(pod) >= distance) {
                    winners.add(pod);
                }
            }
            break;
        }
        return winners;
    }
}
