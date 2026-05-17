package com.example.prathamachikitse

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class EmergencyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_emergency, container, false)
        setupClickListeners(view)
        return view
    }

    private fun setupClickListeners(view: View) {
        view.findViewById<CardView>(R.id.cardSnakeBite).setOnClickListener {
            openDetails("Snake Bite",
                "DO: Keep the victim calm. Immobilize the bitten limb. Keep it below heart level. Remove rings/watches. Get to a hospital immediately.\n\nDON'T: Don't cut the wound. Don't suck the venom. Don't apply ice. Don't use a tourniquet.",
                "ಮಾಡು: ಬಲಿಪಶುವನ್ನು ಶಾಂತವಾಗಿರಿಸಿ. ಕಚ್ಚಿದ ಅಂಗವನ್ನು ಚಲಿಸದಂತೆ ಇರಿಸಿ. ಅದನ್ನು ಹೃದಯದ ಮಟ್ಟಕ್ಕಿಂತ ಕೆಳಗೆ ಇರಿಸಿ. ಉಂಗುರಗಳು/ಗಡಿಯಾರಗಳನ್ನು ತೆಗೆದುಹಾಕಿ. ತಕ್ಷಣ ಆಸ್ಪತ್ರೆಗೆ ಹೋಗಿ.\n\nಮಾಡಬೇಡ: ಗಾಯವನ್ನು ಕತ್ತರಿಸಬೇಡಿ. ವಿಷವನ್ನು ಹೀರಬೇಡಿ. ಐಸ್ ಹಚ್ಚಬೇಡಿ. ಟೂರ್ನಿಕೆಟ್ ಬಳಸಬೇಡಿ.")
        }

        view.findViewById<CardView>(R.id.cardHeartAttack).setOnClickListener {
            openDetails("Heart Attack",
                "DO: Call for emergency help (108). Make the person sit or lie down. Loosen tight clothing. Give Aspirin if recommended. Start CPR if unconscious.\n\nDON'T: Don't leave the person alone. Don't wait to see if symptoms go away. Don't give them anything to eat or drink.",
                "ಮಾಡು: ತುರ್ತು ಸಹಾಯಕ್ಕಾಗಿ ಕರೆ ಮಾಡಿ (108). ವ್ಯಕ್ತಿಯನ್ನು ಕುಳಿತುಕೊಳ್ಳುವಂತೆ ಅಥವಾ ಮಲಗುವಂತೆ ಮಾಡಿ. ಬಿಗಿಯಾದ ಬಟ್ಟೆಯನ್ನು ಸಡಿಲಗೊಳಿಸಿ. ಶಿಫಾರಸು ಮಾಡಿದರೆ ಆಸ್ಪಿರಿನ್ ನೀಡಿ. ಪ್ರಜ್ಞಾಹೀನರಾಗಿದ್ದರೆ ಸಿಪಿಆರ್ ಪ್ರಾರಂಭಿಸಿ.\n\nಮಾಡಬೇಡ: ವ್ಯಕ್ತಿಯನ್ನು ಒಂಟಿಯಾಗಿ ಬಿಡಬೇಡಿ. ಲಕ್ಷಣಗಳು ಹೋಗುತ್ತವೆಯೇ ಎಂದು ನೋಡಲು ಕಾಯಬೇಡಿ. ಅವರಿಗೆ ತಿನ್ನಲು ಅಥವಾ ಕುಡಿಯಲು ಏನನ್ನೂ ನೀಡಬೇಡಿ.")
        }

        view.findViewById<CardView>(R.id.cardFracture).setOnClickListener {
            openDetails("Fracture",
                "DO: Stop any bleeding. Immobilize the injured area. Apply ice packs to reduce swelling. Treat for shock if needed.\n\nDON'T: Don't try to realign the bone. Don't move the injured person unless necessary. Don't test the bone's strength.",
                "ಮಾಡು: ಯಾವುದೇ ರಕ್ತಸ್ರಾವವನ್ನು ನಿಲ್ಲಿಸಿ. ಗಾಯಗೊಂಡ ಪ್ರದೇಶವನ್ನು ಚಲಿಸದಂತೆ ಇರಿಸಿ. ಊತವನ್ನು ಕಡಿಮೆ ಮಾಡಲು ಐಸ್ ಪ್ಯಾಕ್ ಹಚ್ಚಿ. ಅಗತ್ಯವಿದ್ದರೆ ಆಘಾತಕ್ಕೆ ಚಿಕಿತ್ಸೆ ನೀಡಿ.\n\nಮಾಡಬೇಡ: ಮೂಳೆಯನ್ನು ಮರುಹೊಂದಿಸಲು ಪ್ರಯತ್ನಿಸಬೇಡಿ. ಅಗತ್ಯವಿಲ್ಲದಿದ್ದರೆ ಗಾಯಗೊಂಡ ವ್ಯಕ್ತಿಯನ್ನು ಚಲಿಸಬೇಡಿ. ಮೂಳೆಯ ಬಲವನ್ನು ಪರೀಕ್ಷಿಸಬೇಡಿ.")
        }

        view.findViewById<CardView>(R.id.cardChoking).setOnClickListener {
            openDetails("Choking",
                "DO: Encourage coughing. Perform Heimlich maneuver (abdominal thrusts). Call 108 if the person becomes unconscious.\n\nDON'T: Don't perform blind finger sweeps. Don't hit the person on the back if they are coughing strongly.",
                "ಮಾಡು: ಕೆಮ್ಮಲು ಪ್ರೋತ್ಸಾಹಿಸಿ. ಹೈಮ್ಲಿಚ್ ಮ್ಯಾನ್ಯೂವರ್ (ಹೊಟ್ಟೆಯ ತಳ್ಳುವಿಕೆ) ಮಾಡಿ. ವ್ಯಕ್ತಿ ಪ್ರಜ್ಞಾಹೀನರಾದರೆ 108 ಗೆ ಕರೆ ಮಾಡಿ.\n\nಮಾಡಬೇಡ: ಕುರುಡು ಬೆರಳು ಗುಡಿಸುವಿಕೆಯನ್ನು ಮಾಡಬೇಡಿ. ವ್ಯಕ್ತಿಯು ಬಲವಾಗಿ ಕೆಮ್ಮುತ್ತಿದ್ದರೆ ಬೆನ್ನಿನ ಮೇಲೆ ಹೊಡೆಯಬೇಡಿ.")
        }

        view.findViewById<CardView>(R.id.cardBurns).setOnClickListener {
            openDetails("Burns",
                "DO: Run cool (not cold) water over the burn for 10-20 minutes. Remove jewelry before swelling. Cover with a clean, dry cloth.\n\nDON'T: Don't use ice, butter, or ointments. Don't pop blisters. Don't remove clothing stuck to the burn.",
                "ಮಾಡು: ಸುಟ್ಟ ಗಾಯದ ಮೇಲೆ 10-20 ನಿಮಿಷಗಳ ಕಾಲ ತಂಪಾದ (ತಣ್ಣನೆಯಲ್ಲ) ನೀರನ್ನು ಹರಿಸಿರಿ. ಊತ ಬರುವ ಮೊದಲು ಆಭರಣಗಳನ್ನು ತೆಗೆದುಹಾಕಿ. ಸ್ವಚ್ಛವಾದ, ಒಣ ಬಟ್ಟೆಯಿಂದ ಮುಚ್ಚಿ.\n\nಮಾಡಬೇಡ: ಐಸ್, ಬೆಣ್ಣೆ ಅಥವಾ ಮುಲಾಮುಗಳನ್ನು ಬಳಸಬೇಡಿ. ಗುಳ್ಳೆಗಳನ್ನು ಒಡೆಯಬೇಡಿ. ಸುಟ್ಟ ಗಾಯಕ್ಕೆ ಅಂಟಿಕೊಂಡಿರುವ ಬಟ್ಟೆಯನ್ನು ತೆಗೆಯಬೇಡಿ.")
        }

        view.findViewById<CardView>(R.id.cardElectricShock).setOnClickListener {
            openDetails("Electric Shock",
                "DO: Turn off the power source. Use a non-conducting object (wood) to move the person. Check breathing and start CPR if needed. Cover burns.\n\nDON'T: Don't touch the person if they are still in contact with the current. Don't move the person unless in danger.",
                "ಮಾಡು: ವಿದ್ಯುತ್ ಮೂಲವನ್ನು ಆಫ್ ಮಾಡಿ. ವ್ಯಕ್ತಿಯನ್ನು ಸರಿಸಲು ವಾಹಕವಲ್ಲದ ವಸ್ತುವನ್ನು (ಮರ) ಬಳಸಿ. ಉಸಿರಾಟವನ್ನು ಪರೀಕ್ಷಿಸಿ ಮತ್ತು ಅಗತ್ಯವಿದ್ದರೆ ಸಿಪಿಆರ್ ಪ್ರಾರಂಭಿಸಿ. ಸುಟ್ಟ ಗಾಯಗಳನ್ನು ಮುಚ್ಚಿ.\n\nಮಾಡಬೇಡ: ವ್ಯಕ್ತಿಯು ಇನ್ನೂ ವಿದ್ಯುತ್ ಸಂಪರ್ಕದಲ್ಲಿದ್ದರೆ ಅವರನ್ನು ಮುಟ್ಟಬೇಡಿ. ಅಪಾಯದಲ್ಲದ ಹೊರತು ವ್ಯಕ್ತಿಯನ್ನು ಸರಿಸಬೇಡಿ.")
        }
    }

    private fun openDetails(type: String, english: String, kannada: String) {
        val intent = Intent(requireContext(), DetailActivity::class.java).apply {
            putExtra("EMERGENCY_TYPE", type)
            putExtra("ENGLISH_TEXT", english)
            putExtra("KANNADA_TEXT", kannada)
        }
        startActivity(intent)
    }
}