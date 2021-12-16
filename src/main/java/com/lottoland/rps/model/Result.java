package com.lottoland.rps.model;

public enum Result {

	DRAW("Draw"), //
	WIN("Player One Wins"), //
	LOSE("Player Two Wins"),//

	;

	private final String displayName;

	Result(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
