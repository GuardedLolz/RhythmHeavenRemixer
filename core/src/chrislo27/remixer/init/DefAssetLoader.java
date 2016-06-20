package chrislo27.remixer.init;

import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import chrislo27.remixer.game.Cue;
import chrislo27.remixer.game.Game;
import chrislo27.remixer.registry.CueList;
import chrislo27.remixer.registry.GameList;
import ionium.animation.Animation;
import ionium.registry.handler.IAssetLoader;
import ionium.templates.Main;
import ionium.util.AssetMap;

public class DefAssetLoader implements IAssetLoader {

	@Override
	public void addManagedAssets(AssetManager manager) {
		manager.load(AssetMap.add("mainMenuMusic", "music/Off to Osaka.ogg"), Music.class);
		manager.load(AssetMap.add("rhLogo", "images/logo/rhlogo.png"), Texture.class);
		manager.load(AssetMap.add("architectLogo", "images/logo/architect.png"), Texture.class);

		for (Game g : GameList.instance().map.getAllValues()) {
			manager.load(AssetMap.add(g.getIconId(), g.getIconLocation().path()), Texture.class);
		}

		for (Cue c : CueList.instance().map.getAllValues()) {
			manager.load(AssetMap.add(c.id, c.location.path()), Sound.class);
		}
	}

	@Override
	public void addUnmanagedTextures(HashMap<String, Texture> textures) {
		textures.put("splashLogo", new Texture("images/logo/splash.png"));
	}

	@Override
	public void addUnmanagedAnimations(HashMap<String, Animation> animations) {
	}

}
