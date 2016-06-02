package chrislo27.remixer.registry;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import chrislo27.remixer.game.CountInGame;
import chrislo27.remixer.game.DonkDonk;
import chrislo27.remixer.game.Game;
import chrislo27.remixer.game.Lockstep;
import chrislo27.remixer.game.MunchyMonk;
import chrislo27.remixer.game.TapTrial;
import chrislo27.remixer.game.TapTroupe;
import ionium.registry.AssetRegistry;
import ionium.util.BiObjectMap;

public class GameList {

	private static GameList instance;

	private GameList() {
	}

	public static GameList instance() {
		if (instance == null) {
			instance = new GameList();
			instance.loadResources();
		}
		return instance;
	}

	public BiObjectMap<String, Game> games = new BiObjectMap<>();

	private void loadResources() {
		put(new CountInGame("countIn"));
		
		put(new Lockstep("lockstep"));
		put(new MunchyMonk("munchyMonk"));
		put(new DonkDonk("donkDonk"));
		put(new TapTroupe("tapTroupe"));
		put(new TapTrial("tapTrial"));

		games.getAllKeys().sort();
		games.getAllValues().sort();

	}

	public void put(Game game) {
		games.put(game.name, game);
	}

	public static Game getGame(String key) {
		return instance().games.getValue(key);
	}

	public static AtlasRegion getIcon(String key) {
		return AssetRegistry.getAtlasRegion("gameIcons", key);
	}

}
