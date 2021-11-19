using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    public static GameManager _instance = null;

    [SerializeField]
    private LevelManager _levelManager;

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
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
