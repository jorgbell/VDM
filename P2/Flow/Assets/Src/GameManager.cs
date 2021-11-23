using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    public static GameManager _instance = null;

    [SerializeField]
    private LevelManager _levelManager;

    //DEBERIAMOS USAR NAMESPACES
    //No deberia guardar lotes de niveles, sino CATEGORIAS (intro, manias, etc)
    //que dentro tienen los LevelPack
    public LevelPack[] levels;


    private void Awake()
    {
        if(_instance != null)
        {
            _instance._levelManager = _levelManager;
        }
    }

    // Start is called before the first frame update
    void Start()
    {
        //ejemplo esto se hará bien en un futuro
        //levels[0].maps.toString();
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
