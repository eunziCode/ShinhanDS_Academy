package com.shinhan.day08.lab;

public class TV implements Volume {
	// 1.field
	int VolLevel = 0;

	// 2.일반메서드
	@Override
	public void volumeUp(int level) {
		VolLevel += level;

		System.out.println(getClass().getSimpleName() + "볼륨 올립니다. " + VolLevel);
	}

	@Override
	public void volumeDown(int level) {
		VolLevel -= level;

		if (VolLevel <= 0) 
			VolLevel = 0;
		System.out.println(getClass().getSimpleName() + "볼륨 올립니다. " + VolLevel);
	}
}
