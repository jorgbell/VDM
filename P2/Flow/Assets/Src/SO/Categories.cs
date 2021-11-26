using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace Flow
{
    //nombre de fichero que propone al crearlo, nombre del menu a la hora de crearlo, orden en el menu de Assets
    [CreateAssetMenu(fileName = "levelCategory", menuName = "Flow/Level Category", order = 2)]
    public class Categories : ScriptableObject
    {
        [Tooltip("Nombre de la categor�a")]
        public string _categoryName;
        [Tooltip("Lotes de niveles asociado")]
        public LevelPack[] _packages;
        [Tooltip("Paleta de colores, m�ximo 16")]
        public Color[] _colorPalette;
    }
}

