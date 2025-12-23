namespace MoodByte
{
    partial class CrearArticulo
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
            lblTitulo = new Label();
            lblSubtitulo = new Label();
            lblEnlace = new Label();
            lblImagen = new Label();
            txtTitulo = new TextBox();
            txtSubtitulo = new TextBox();
            txtEnlace = new TextBox();
            txtImagen = new TextBox();
            btnGuardar = new Button();
            buttonLimpiar = new Button();
            epArticulo = new ErrorProvider(components);
            ((System.ComponentModel.ISupportInitialize)epArticulo).BeginInit();
            SuspendLayout();
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Location = new Point(233, 91);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(50, 20);
            lblTitulo.TabIndex = 0;
            lblTitulo.Text = "Titulo:";
            // 
            // lblSubtitulo
            // 
            lblSubtitulo.AutoSize = true;
            lblSubtitulo.Location = new Point(233, 189);
            lblSubtitulo.Name = "lblSubtitulo";
            lblSubtitulo.Size = new Size(72, 20);
            lblSubtitulo.TabIndex = 1;
            lblSubtitulo.Text = "Subtítulo:";
            // 
            // lblEnlace
            // 
            lblEnlace.AutoSize = true;
            lblEnlace.Location = new Point(233, 283);
            lblEnlace.Name = "lblEnlace";
            lblEnlace.Size = new Size(55, 20);
            lblEnlace.TabIndex = 2;
            lblEnlace.Text = "Enlace:";
            // 
            // lblImagen
            // 
            lblImagen.AutoSize = true;
            lblImagen.Location = new Point(233, 387);
            lblImagen.Name = "lblImagen";
            lblImagen.Size = new Size(62, 20);
            lblImagen.TabIndex = 3;
            lblImagen.Text = "Imagen:";
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(381, 91);
            txtTitulo.Margin = new Padding(3, 4, 3, 4);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(221, 27);
            txtTitulo.TabIndex = 4;
            // 
            // txtSubtitulo
            // 
            txtSubtitulo.Location = new Point(381, 189);
            txtSubtitulo.Margin = new Padding(3, 4, 3, 4);
            txtSubtitulo.Name = "txtSubtitulo";
            txtSubtitulo.Size = new Size(221, 27);
            txtSubtitulo.TabIndex = 5;
            // 
            // txtEnlace
            // 
            txtEnlace.Location = new Point(381, 283);
            txtEnlace.Margin = new Padding(3, 4, 3, 4);
            txtEnlace.Name = "txtEnlace";
            txtEnlace.Size = new Size(221, 27);
            txtEnlace.TabIndex = 6;
            // 
            // txtImagen
            // 
            txtImagen.Location = new Point(381, 387);
            txtImagen.Margin = new Padding(3, 4, 3, 4);
            txtImagen.Name = "txtImagen";
            txtImagen.Size = new Size(221, 27);
            txtImagen.TabIndex = 7;
            // 
            // btnGuardar
            // 
            btnGuardar.Location = new Point(517, 492);
            btnGuardar.Margin = new Padding(3, 4, 3, 4);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(86, 31);
            btnGuardar.TabIndex = 8;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = true;
            btnGuardar.Click += btnGuardar_Click;
            // 
            // buttonLimpiar
            // 
            buttonLimpiar.Location = new Point(370, 492);
            buttonLimpiar.Margin = new Padding(3, 4, 3, 4);
            buttonLimpiar.Name = "buttonLimpiar";
            buttonLimpiar.Size = new Size(86, 31);
            buttonLimpiar.TabIndex = 9;
            buttonLimpiar.Text = "Limpiar";
            buttonLimpiar.UseVisualStyleBackColor = true;
            buttonLimpiar.Click += buttonLimpiar_Click;
            // 
            // epArticulo
            // 
            epArticulo.ContainerControl = this;
            // 
            // CrearArticulo
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(914, 600);
            Controls.Add(buttonLimpiar);
            Controls.Add(btnGuardar);
            Controls.Add(txtImagen);
            Controls.Add(txtEnlace);
            Controls.Add(txtSubtitulo);
            Controls.Add(txtTitulo);
            Controls.Add(lblImagen);
            Controls.Add(lblEnlace);
            Controls.Add(lblSubtitulo);
            Controls.Add(lblTitulo);
            Margin = new Padding(3, 4, 3, 4);
            Name = "CrearArticulo";
            Text = "CrearArticulo";
            Load += CrearArticulo_Load;
            ((System.ComponentModel.ISupportInitialize)epArticulo).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblTitulo;
        private Label lblSubtitulo;
        private Label lblEnlace;
        private Label lblImagen;
        private TextBox txtTitulo;
        private TextBox txtSubtitulo;
        private TextBox txtEnlace;
        private TextBox txtImagen;
        private Button btnGuardar;
        private Button buttonLimpiar;
        private ErrorProvider epArticulo;
    }
}