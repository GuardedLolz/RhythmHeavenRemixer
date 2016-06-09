package chrislo27.remixer.registry;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.ObjectMap;

import chrislo27.remixer.game.BlueBirds;
import chrislo27.remixer.game.BuiltToScaleDS;
import chrislo27.remixer.game.ClappyTrio;
import chrislo27.remixer.game.CountInGame;
import chrislo27.remixer.game.CropStomp;
import chrislo27.remixer.game.CustomSound;
import chrislo27.remixer.game.DogNinja;
import chrislo27.remixer.game.DonkDonk;
import chrislo27.remixer.game.Fillbots;
import chrislo27.remixer.game.Game;
import chrislo27.remixer.game.GleeClub;
import chrislo27.remixer.game.KarateMan;
import chrislo27.remixer.game.Lockstep;
import chrislo27.remixer.game.Lockstep2;
import chrislo27.remixer.game.MicroRow;
import chrislo27.remixer.game.MoaiDooWop;
import chrislo27.remixer.game.MunchyMonk;
import chrislo27.remixer.game.RhythmRally;
import chrislo27.remixer.game.Ringside;
import chrislo27.remixer.game.ShootEmUp;
import chrislo27.remixer.game.ShrimpShuffle;
import chrislo27.remixer.game.SpaceDance;
import chrislo27.remixer.game.SpaceSoccer;
import chrislo27.remixer.game.TapTrial;
import chrislo27.remixer.game.TapTroupe;
import chrislo27.remixer.game.VegetaPull;
import chrislo27.remixer.game.WizardWaltz;
import chrislo27.remixer.game.WorkingDough;
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
	public TextureAtlas atlas;
	public ObjectMap<String, AtlasRegion> allRegions;

	private void loadResources() {
		put(new CountInGame("countIn"));
		put(new CustomSound("custom"));

		put(new Lockstep("lockstep"));
		put(new MunchyMonk("munchyMonk"));
		put(new DonkDonk("donkDonk"));
		put(new TapTroupe("tapTroupe"));
		put(new TapTrial("tapTrial"));
		put(new SpaceDance("spaceDance", "megaminerzero"));
		put(new CropStomp("cropStomp", "Chocolate2890"));
		put(new BlueBirds("blueBirds", "Chocolate2890"));
		put(new KarateMan("karateMan", "Chocolate2890"));
		put(new Ringside("ringside", null));
		put(new ShootEmUp("shootEmUp", null));
		put(new WorkingDough("workingDough", null));
		put(new MoaiDooWop("moaiDooWop", null));
		put(new DogNinja("dogNinja", null));
		put(new ShrimpShuffle("shrimpShuffle", null));
		put(new RhythmRally("rhythmRally", null));
		put(new SpaceSoccer("spaceSoccer", "Chocolate2890"));
		put(new MicroRow("microRow", "serena"));
		put(new ClappyTrio("clappyTrio", null));
		put(new VegetaPull("vegetaPull", "megaminerzero"));
		put(new WizardWaltz("wizardWaltz", null));
		put(new GleeClub("gleeClub", "ahemtoday"));
		put(new Fillbots("fillbots", null));
		put(new Lockstep2("lockstep2", null));
		put(new BuiltToScaleDS("builtToScaleDS", "DeltaGrovyle"));

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
		return instance().allRegions.get(key);
	}

}
