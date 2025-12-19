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
            ((System.ComponentModel.ISupportInitialize)epFrase).BeginInit();
            SuspendLayout();
            // 
            // lblEstado
            // 
            lblEstado.AutoSize = true;
            lblEstado.Location = new Point(238, 127);
            lblEstado.Name = "lblEstado";
            lblEstado.Size = new Size(45, 15);
            lblEstado.TabIndex = 0;
            lblEstado.Text = "Estado:";
            // 
            // lblFrase
            // 
            lblFrase.AutoSize = true;
            lblFrase.Location = new Point(238, 221);
            lblFrase.Name = "lblFrase";
            lblFrase.Size = new Size(37, 15);
            lblFrase.TabIndex = 1;
            lblFrase.Text = "Frase:";
            // 
            // cmbEstado
            // 
            cmbEstado.FormattingEnabled = true;
            cmbEstado.Location = new Point(302, 127);
            cmbEstado.Name = "cmbEstado";
            cmbEstado.Size = new Size(160, 23);
            cmbEstado.TabIndex = 2;
            // 
            // txtFrase
            // 
            txtFrase.Location = new Point(302, 218);
            txtFrase.Name = "txtFrase";
            txtFrase.Size = new Size(277, 23);
            txtFrase.TabIndex = 3;
            // 
            // btnGuardar
            // 
            btnGuardar.Location = new Point(504, 309);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(75, 23);
            btnGuardar.TabIndex = 4;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = true;
            btnGuardar.Click += btnGuardar_Click;
            // 
            // buttonLimpiar
            // 
            buttonLimpiar.Location = new Point(346, 309);
            buttonLimpiar.Name = "buttonLimpiar";
            buttonLimpiar.Size = new Size(75, 23);
            buttonLimpiar.TabIndex = 5;
            buttonLimpiar.Text = "Limpiar";
            buttonLimpiar.UseVisualStyleBackColor = true;
            buttonLimpiar.Click += buttonLimpiar_Click;
            // 
            // epFrase
            // 
            epFrase.ContainerControl = this;
            // 
            // CrearFrase
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(buttonLimpiar);
            Controls.Add(btnGuardar);
            Controls.Add(txtFrase);
            Controls.Add(cmbEstado);
            Controls.Add(lblFrase);
            Controls.Add(lblEstado);
            Name = "CrearFrase";
            Text = "CrearFrase";
            ((System.ComponentModel.ISupportInitialize)epFrase).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblEstado;
        private Label lblFrase;
        private ComboBox cmbEstado;
        private TextBox txtFrase;
        private Button btnGuardar;
        private Button buttonLimpiar;
        private ErrorProvider epFrase;
    }
}