using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace Flow 
{
    public class Tile : MonoBehaviour
    {
        public SpriteRenderer _circle;
        private Color _color;
        private bool _enabled;

#if UNITY_EDITOR
        // Start is called before the first frame update
        void Start()
        {
            if (_circle == null)
            {
                Debug.LogError("No hay circulo");
                _enabled = false;
                return;
            }
        }
#endif

        // Update is called once per frame
        void Update()
        {

        }

        public void EnableCircle()
        {

        }

        public void SetColor(Color c)
        {

        }
    }

}