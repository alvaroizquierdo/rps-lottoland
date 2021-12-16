package com.lottoland.rps.model;

public enum Choice {

	ROCK {
		@Override
		public boolean winsWith(Choice other) {
			return SCISSORS.equals(other);
		}
	}, //
	PAPER {
		@Override
		public boolean winsWith(Choice other) {
			return ROCK.equals(other);
		}
	}, //
	SCISSORS {
		@Override
		public boolean winsWith(Choice other) {
			return PAPER.equals(other);
		}
	};

	public abstract boolean winsWith(Choice other);

	public Result resultWith(Choice other) {

		if (other == null) {
			throw new IllegalArgumentException("Other choice cannot be null");
		}

		if (this.equals(other)) {
			return Result.DRAW;
		}
		if (this.winsWith(other)) {
			return Result.WIN;
		} else {
			return Result.LOSE;
		}
	}

}
