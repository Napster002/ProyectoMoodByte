namespace MoodByte
{
    partial class CrearFrase
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            lblEstado = new Label();
            lblFrase = new Label();
            cmbEstado = new ComboBox();
            txtFrase = new TextBox();
            btnGuardar = new Button();
            buttonLimpiar = new Button();
            epFrase = new ErrorProvider(components);
            panelCrearFrases = new Panel();
            ((System.ComponentModel.ISupportInitialize)epFrase).BeginInit();
            panelCrearFrases.SuspendLayout();
            SuspendLayout();
            // 
            // lblEstado
            // 
            lblEstado.AutoSize = true;
            lblEstado.Font = new Font("Segoe UI", 10.2F, FontStyle.Bold);
            lblEstado.ForeColor = Color.FromArgb(245, 109, 95);
            lblEstado.Location = new Point(22, 57);
            lblEstado.Name = "lblEstado";
            lblEstado.Size = new Size(63, 23);
            lblEstado.TabIndex = 0;
            lblEstado.Text = "Estado";
            // 
            // lblFrase
            // 
            lblFrase.AutoSize = true;
            lblFrase.Font = new Font("Segoe UI", 10.2F, FontStyle.Bold);
            lblFrase.ForeColor = Color.FromArgb(245, 109, 95);
            lblFrase.Location = new Point(30, 179);
            lblFrase.Name = "lblFrase";
            lblFrase.Size = new Size(51, 23);
            lblFrase.TabIndex = 1;
            lblFrase.Text = "Frase";
            // 
            // cmbEstado
            // 
            cmbEstado.FormattingEnabled = true;
            cmbEstado.Items.AddRange(new object[] { "Muy bien", "Bien", "Normal", "Un poco mal", "Triste" });
            cmbEstado.Location = new Point(91, 56);
            cmbEstado.Margin = new Padding(3, 4, 3, 4);
            cmbEstado.Name = "cmbEstado";
            cmbEstado.Size = new Size(182, 28);
            cmbEstado.TabIndex = 2;
            // 
            // txtFrase
            // 
            txtFrase.BorderStyle = BorderStyle.FixedSingle;
            txtFrase.Location = new Point(91, 178);
            txtFrase.Margin = new Padding(3, 4, 3, 4);
            txtFrase.Name = "txtFrase";
            txtFrase.Size = new Size(316, 27);
            txtFrase.TabIndex = 3;
            // 
            // btnGuardar
            // 
            btnGuardar.BackColor = Color.FromArgb(252, 144, 139);
            btnGuardar.FlatAppearance.BorderSize = 0;
            btnGuardar.FlatStyle = FlatStyle.Flat;
            btnGuardar.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnGuardar.ForeColor = SystemColors.ButtonHighlight;
            btnGuardar.Location = new Point(265, 302);
            btnGuardar.Margin = new Padding(3, 4, 3, 4);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(142, 31);
            btnGuardar.TabIndex = 4;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = false;
            btnGuardar.Click += btnGuardar_Click;
            // 
            // buttonLimpiar
            // 
            buttonLimpiar.BackColor = Color.FromArgb(252, 144, 139);
            buttonLimpiar.FlatAppearance.BorderSize = 0;
            buttonLimpiar.FlatStyle = FlatStyle.Flat;
            buttonLimpiar.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            buttonLimpiar.ForeColor = SystemColors.ButtonHighlight;
            buttonLimpiar.Location = new Point(90, 302);
            buttonLimpiar.Margin = new Padding(3, 4, 3, 4);
            buttonLimpiar.Name = "buttonLimpiar";
            buttonLimpiar.Size = new Size(142, 31);
            buttonLimpiar.TabIndex = 5;
            buttonLimpiar.Text = "Limpiar";
            buttonLimpiar.UseVisualStyleBackColor = false;
            buttonLimpiar.Click += buttonLimpiar_Click;
            // 
            // epFrase
            // 
            epFrase.ContainerControl = this;
            // 
            // panelCrearFrases
            // 
            panelCrearFrases.Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right;
            panelCrearFrases.BackColor = Color.FromArgb(96, 245, 216);
            panelCrearFrases.BorderStyle = BorderStyle.FixedSingle;
            panelCrearFrases.Controls.Add(txtFrase);
            panelCrearFrases.Controls.Add(buttonLimpiar);
            panelCrearFrases.Controls.Add(lblEstado);
            panelCrearFrases.Controls.Add(btnGuardar);
            panelCrearFrases.Controls.Add(lblFrase);
            panelCrearFrases.Controls.Add(cmbEstado);
            panelCrearFrases.Location = new Point(223, 64);
            panelCrearFrases.Name = "panelCrearFrases";
            panelCrearFrases.Size = new Size(468, 435);
            panelCrearFrases.TabIndex = 6;
            // 
            // CrearFrase
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.FromArgb(253, 238, 228);
            ClientSize = new Size(914, 600);
            Controls.Add(panelCrearFrases);
            Margin = new Padding(3, 4, 3, 4);
            Name = "CrearFrase";
            Text = "Crear Frases";
            ((System.ComponentModel.ISupportInitialize)epFrase).EndInit();
            panelCrearFrases.ResumeLayout(false);
            panelCrearFrases.PerformLayout();
            ResumeLayout(false);
        }

        #endregion

        private Label lblEstado;
        private Label lblFrase;
        private ComboBox cmbEstado;
        private TextBox txtFrase;
        private Button btnGuardar;
        private Button buttonLimpiar;
        private ErrorProvider epFrase;
        private Panel panelCrearFrases;
    }
}