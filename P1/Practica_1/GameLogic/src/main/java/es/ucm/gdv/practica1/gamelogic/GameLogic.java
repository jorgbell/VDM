package es.ucm.gdv.practica1.gamelogic;


import java.util.List;

import es.ucm.gdv.practica1.engine.Engine;
import es.ucm.gdv.practica1.engine.FloatPair;
import es.ucm.gdv.practica1.engine.Game;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Image;
import es.ucm.gdv.practica1.engine.TouchEvent;



public class GameLogic implements Game {
    public GameLogic(){}

    public enum GameState{
        MENU_STATE,
        CONFIG_STATE,
        GAME_STATE,
        END_STATE
    }

    @Override
    public void setEngine(Engine e){_myEngine = e;}

    @Override
    public boolean init(){
        _myGraphics = _myEngine.getGraphics();
        // CARGA DE RECURSOS
        _textFont = _myGraphics.newFont("fonts/JosefinSans-Bold.ttf",90,true);
        _titleFont = _myGraphics.newFont("fonts/Molle-Regular.ttf",150,true);
        _closeSprite = _myGraphics.newImage("sprites/close.png");
        _eyeSprite = _myGraphics.newImage("sprites/eye.png");
        _historySprite = _myGraphics.newImage("sprites/history.png");
        _lockSprite = _myGraphics.newImage("sprites/lock.png");
        _q42Sprite = _myGraphics.newImage("sprites/q42.png");

        //INICIALIZACIÓN DE LA LÓGICA
        _actualState = GameState.MENU_STATE;
        _tablero = new Tablero(4); //inicializar luego
        //_myPistas = new Pistas(); //inicializar luego
        //Menu
        _startGamePos = new FloatPair(_myGraphics.getGameWidth()/2-40, _myGraphics.getGameHeight()/2 - 40);
        _b = new OhNoButton(_startGamePos, new FloatPair(70,70),70, 0xFFFFFFFF, _myGraphics, _tablero, new FloatPair(0,0), _textFont);

        return true;
    }


    @Override
    public void update(double deltaTime) {
        switch (_actualState){
            case MENU_STATE:
                break;
            case CONFIG_STATE:
                break;
            case GAME_STATE:
                break;
            case END_STATE:
                break;
        }
    }

    @Override
    public void render() {
        // Borramos el fondo.
        _myGraphics.clearGame(0xFFFFFFFF);
        _myGraphics.clearGame(0xFF804736);
        switch (_actualState){
            case MENU_STATE:
                _myGraphics.setColor(0xFF000000);
                _myGraphics.setFont(_titleFont);
                _myGraphics.drawText("Oh no", _myGraphics.getGameWidth()/2 -50, _myGraphics.getGameHeight()/12);
                _myGraphics.setFont(_textFont);
                _myGraphics.drawText("Jugar", (int)_startGamePos._x, (int)_startGamePos._y);
                _myGraphics.setColor(0xFF808080);
                _myGraphics.drawText("Un juego copiado a Q42", _myGraphics.getGameWidth()/3, _myGraphics.getGameHeight() - _myGraphics.getGameHeight()/3);
                _myGraphics.drawImage(_q42Sprite, _myGraphics.getGameWidth()/2, _myGraphics.getGameHeight() - _myGraphics.getGameHeight()/4, 0.1f,0.1f);
                _b.render();
                break;
            case CONFIG_STATE:
                break;
            case GAME_STATE:
                break;
            case END_STATE:
                break;
        }

    }

    @Override
    public void getInput() {
        List<TouchEvent> inputList = _myEngine.getInput().getTouchEvents();
        while(inputList.size()>0){//mientras haya input que procesar
            TouchEvent aux = inputList.get(0); //cogemos el primero a procesar
            inputList.remove(0); //lo borramos de la lista
            processInput(aux); //lo procesamos
        }
    }

    //Método para implementar la lógica del input
    private void processInput(TouchEvent input){

        switch (_actualState){
            case MENU_STATE:
                switch (input.get_type()){
                    case PULSAR:
                        if(!input.isRightClick()){
                            System.out.print("Pulsaste click izq\n");
                            if(_b._rect.checkCollision(input.get_posX(), input.get_posY()));
                                System.out.print("JODEEEEEEEEEEEEEER\n");
                        }
                        else
                            System.out.print("Pulsaste click derecho\n");
                        break;
                    case SOLTAR:
                        if(!input.isRightClick())
                            System.out.print("Soltaste el click izquierdo\n");
                        else
                            System.out.print("Soltaste el click derecho\n");
                        break;
                    default:
                        break;
                }
                break;
            case CONFIG_STATE:
                break;
            case GAME_STATE:
                break;
            case END_STATE:
                break;
        }

    }

    public Tablero getTablero(){
        return _tablero;
    }

    public GameState getGameState(){
        return _actualState;
    }
    public void setGameState(GameState s){
        _actualState = s;
    }

    //VARIABLES PRIVADAS

    private Engine _myEngine; //podrá ser de tipo Android o PC.
    private Graphics _myGraphics;
    private Tablero _tablero;
    //private Pistas _myPistas;
    private GameState _actualState;
    private OhNoButton _b;
    FloatPair _startGamePos;
    //resources
    private Font _textFont;
    private Font _titleFont;
    private Image _closeSprite;
    private Image _eyeSprite;
    private Image _historySprite;
    private Image _lockSprite;
    private Image _q42Sprite;





}