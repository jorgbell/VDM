using System.Collections;
using System.Collections.Generic;
using UnityEngine;


//nombre de fichero que propone al crearlo, nombre del menu a la hora de crearlo, orden en el menu de Assets
[CreateAssetMenu(fileName = "levelpack", menuName = "Flow/Level pack", order =1)]
public class LevelPack : ScriptableObject
{
    [Tooltip("Nombre del Lote")]
    public TextAsset maps;
    [Tooltip(".txt del nivel")]
    public string packName;
}
