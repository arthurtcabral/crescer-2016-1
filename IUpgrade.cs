using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegamanLista1
{
    public interface IUpgrade
    {
        int BonusAtaque { get; }
        int BonusDefesa { get; }
        string TipoUpgrade { get; }
    }
}
