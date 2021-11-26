using System.Collections;
using System.Collections.Generic;
using UnityEngine;


namespace Flow
{
    //nombre de fichero que propone al crearlo, nombre del menu a la hora de crearlo, orden en el menu de Assets
    [CreateAssetMenu(fileName = "levelpack", menuName = "Flow/Level pack", order = 1)]
    public class LevelPack : ScriptableObject
    {
        [Tooltip(".txt del nivel")]
        public TextAsset maps;
        [Tooltip("Nombre del Lote")]
        public string packName;
    }
}

