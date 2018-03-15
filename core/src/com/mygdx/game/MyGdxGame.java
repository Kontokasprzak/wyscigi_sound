import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class MyGdxGame implements Screen{
	SpriteBatch batch;
	 Texture audi;
	Texture siatka;
	Texture mapa;



	Sprite auto;
	OrthographicCamera camera;
	float auto_x, auto_y;
	boolean menu=true;





	@Override
	public void create () {

		batch = new SpriteBatch();
		audi = new Texture("Audi.png");
		mapa = new Texture("mapa.png");
		siatka = new Texture("siatka.png");

		camera= new OrthographicCamera(800,480);
		auto= new Sprite(audi);
		camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
		auto_x=375;
		auto_y=215;

		private void ruch(){

	}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();



			{

				batch.draw(mapa, 0, 0);
				batch.draw(siatka, 0, 0);
				auto.draw(batch);
			}
		}

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();
	}
}
