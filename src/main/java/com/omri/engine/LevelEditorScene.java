package com.omri.engine;

import org.joml.Vector2f;

import com.omri.components.Sprite;
import com.omri.components.SpriteRenderer;
import com.omri.components.Spritesheet;
import com.omri.util.AssetPool;
public class LevelEditorScene extends Scene{
	
	
	public LevelEditorScene() {
		
	}
	
	@Override
	public void init() {
		loadResources();
		this.camera = new Camera(new Vector2f());
		
		Spritesheet sprites = AssetPool.getSpriteSheet("assets/images/spritesheet.png");
		
		GameObject obj1 = new GameObject("object1", new Transform(new Vector2f(100,100), new Vector2f(256, 256)));
		obj1.addComponent(new SpriteRenderer(sprites.getSprite(0)));
		this.addGameObjectToScene(obj1);
		
		GameObject obj2 = new GameObject("object1", new Transform(new Vector2f(400,100), new Vector2f(256, 256)));
		obj2.addComponent(new SpriteRenderer(sprites.getSprite(15)));
		this.addGameObjectToScene(obj2);
		//loadResources();
		
	}
	
	private void loadResources() {
		AssetPool.getShader("assets/shaders/default.glsl");
		AssetPool.addSpriteSheet("assets/images/spritesheet.png", new Spritesheet(AssetPool.getTexture("assets/images/spritesheet.png"), 16, 16, 26, 0));
		
	}

	@Override
	public void update(float dt) {
		System.out.println("FPS: " + (1.0f/dt));
		
		for(GameObject go : this.gameObjects) {
			go.update(dt);
		}
		
		this.renderer.render();
	}
}
