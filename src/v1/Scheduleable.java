package v5;

import java.time.LocalTime;

public interface Scheduleable{
	
	LocalTime[] schedule(AerobicExercise exercise, LocalTime startTime);
}